package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class CartScreenController {
    private Cart cart;

    @FXML private ToggleGroup filterCategory;
    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterID;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private Label totalCost;
    @FXML private Text play_content;
    public CartScreenController(Cart cart) { this.cart = cart; }

    @FXML
    private void initialize()  {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(cart.getItemsOrdered());
        totalCost.setText(String.format("%.2f", cart.totalCost()) + " $");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(observable -> {
            var selected = tblMedia.getSelectionModel().getSelectedItem();
            if (selected == null) return;
            btnRemove.setVisible(true);
            btnPlay.setVisible(selected.isPlayable());
        });

        tfFilter.textProperty().addListener(observable -> { onFilterChange(); });
        filterCategory.selectedToggleProperty().addListener((obserble, oldValue, newValue) -> { onFilterChange(); });
    }

    private void onFilterChange() {
        // Empty filter
        if (tfFilter.getText().length() == 0) {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }

        var button = (RadioButton)filterCategory.getSelectedToggle();
        assert(button != null);
        switch(button.getText()) {
            default:
            case "By Title":
                tblMedia.setItems(cart.filterTitle(tfFilter.getText()));
                break;
            case "By ID":
                tblMedia.setItems(cart.filterId(tfFilter.getText()));
                break;
        }
    }

    @FXML
     void btnRemovePressed(ActionEvent event) {
        cart.removeMedia(tblMedia.getSelectionModel().getSelectedItem());
        if (cart.getItemsOrdered().size() < 1) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }
    @FXML
    void btnPlayPressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        String playContent = null;
        try {
            if (media instanceof DigitalVideoDisc) {
                playContent = ((DigitalVideoDisc) media).play();
            } else {
                // Ném PlayerException nếu không thể phát media
                throw new PlayerException("Invalid media type for play operation");
            }
        } catch (PlayerException ex) {
            System.out.println(ex.getMessage());
        }

        play_content.setText(playContent);
    }
}
