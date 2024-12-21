package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.*;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	private Store store;
	@FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	@FXML
	private Label labelTotalCost;
	
	public CartScreenController(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}
				});
		
		cart.getItemsOrdered().addListener((ListChangeListener<? super Media>) change -> updateTotalCost());
		updateTotalCost();
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		try {
			((Playable) media).play();
		} catch (PlayerException e) {
			e.printStackTrace();
		}
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setTitle("Thử sản phẩm này (Play this media)");
	    alert.setHeaderText(null);
	    try {
			alert.setContentText(((Playable) media).play());
		} catch (PlayerException e) {
			e.printStackTrace();
		}
	    alert.showAndWait();
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setTitle("Thông báo ()");
	    alert.setHeaderText(null);
	    alert.setContentText("Đơn hàng của bạn đã được tạo thành công.");
	    alert.showAndWait();
	    
		cart.getItemsOrdered().clear();
	}
	
	@FXML
	void menuItemViewStorePressed(ActionEvent event) {
		new StoreScreen(store, cart);
	}
	
	@FXML
	void btnAddBookPressed(ActionEvent event) {
		new AddBookToStoreScreen(store, cart);
	}
	
	@FXML
	void btnAddCDPressed(ActionEvent event) {
		new AddCDToStoreScreen(store, cart);
	}
	
	@FXML
	void btnAddDVDPressed(ActionEvent event) {
		new AddDVDToStoreScreen(store, cart);
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}
	
	void updateTotalCost() {
		double totalCost = cart.totalCost();
	    labelTotalCost.setText(String.format("%.2f$", totalCost));
	}
}
