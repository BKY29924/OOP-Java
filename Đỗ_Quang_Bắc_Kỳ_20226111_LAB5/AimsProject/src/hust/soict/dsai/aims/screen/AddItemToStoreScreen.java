package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {
	protected Store store;
	protected Cart cart;
	
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
		JMenuItem smViewStore = new JMenuItem("View store");
		menu.add(smViewStore);
		JMenuItem smViewCart = new JMenuItem("View cart");
		menu.add(smViewCart);
		
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
		
		smViewStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreScreen(store, cart);
			}
        });
		
		smViewCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(store, cart);
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
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter(Cart cart) {
		JPanel center = new JPanel();
		return center;
	}
	
	public AddItemToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(cart), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Add item to Store");
		setSize(500, 360);
	}
}
