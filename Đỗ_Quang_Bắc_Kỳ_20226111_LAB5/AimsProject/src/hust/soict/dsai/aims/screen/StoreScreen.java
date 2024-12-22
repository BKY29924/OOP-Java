package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	private JScrollPane center;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu smUpdateStore = new JMenu("Update store");
		JMenuItem smAddBook = new JMenuItem("Add Book");
		JMenuItem smAddCD = new JMenuItem("Add CD");
		JMenuItem smAddDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(smAddBook);
		smUpdateStore.add(smAddCD);
		smUpdateStore.add(smAddDVD);

		JMenu menu = new JMenu("Options");
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store")); // không cần thêm listener cho nút này vì đang ở store screen sẵn rồi
		JMenuItem smViewCart = new JMenuItem("View cart");
		menu.add(smViewCart);
		
		smViewCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(store, cart);
			}
        });
		
		smAddBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookToStoreScreen(store, cart);
			}
        });
		
		smAddCD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCDToStoreScreen(store, cart);
			}
        });
		
		smAddDVD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddDVDToStoreScreen(store, cart);
			}
        });
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.MAGENTA);
		
		JButton cartBtn = new JButton("View cart");
		cartBtn.setPreferredSize(new Dimension(100, 50));
		cartBtn.setMaximumSize(new Dimension(100, 50));
		
		cartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(store, cart);
			}
        });
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cartBtn);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JScrollPane createCenter(Cart cart) {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            centerPanel.add(cell);
        }

        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        return scrollPane;
	}
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		center = createCenter(cart);
		cp.add(center, BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
}
