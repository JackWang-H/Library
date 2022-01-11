package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.Reader;
import sqlTools.BorrowTools;
import sqlTools.ReaderTools;

public class Return_BookFrame extends JFrame {

	/**
	 * Java�����л�������ͨ��������ʱ�ж����serialVersionUID����֤�汾һ���Ե�
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;

	private JScrollPane bookScrollPane;
	private JTable bookJtable;
	private DefaultTableModel defaultModel;
	public static int row;

	private JLabel idReaderLabel;
	private JLabel nameReaderLabel;
	private JLabel typeLabel;
	private JLabel sexLabel;
	private JLabel passwordLabel;
	private JLabel showidReaderLabel;

	private JLabel showNameReaderLabel;
	private JLabel showTypeLabel;
	private JLabel showSexLabel;
	private JLabel showPasswordLabel;

	private JButton return_BookButton;

	/*	*//**
			 * Launch the application.
			 */
/*	public static void main(String[] args) {
		try {
			Return_BookFrame frame = new Return_BookFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the frame.
	 */
	public Return_BookFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 996, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton borrow_Button = new JButton("����");
		borrow_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_BookFrame search_BookFrame = new Search_BookFrame();
				search_BookFrame.setVisible(true);
				CloseFrame();
			}
		});
		borrow_Button.setBounds(77, 288, 123, 29);
		contentPane.add(borrow_Button);

		JButton self_info_Button = new JButton("����");
		self_info_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Return_BookFrame return_BookFrame = new Return_BookFrame();
				return_BookFrame.setVisible(true);
				CloseFrame();
			}
		});
		self_info_Button.setBounds(77, 474, 123, 29);
		contentPane.add(self_info_Button);

		JButton log_out_Button = new JButton("�ǳ�");
		log_out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				CloseFrame();
			}
		});
		log_out_Button.setBounds(817, 102, 85, 29);
		contentPane.add(log_out_Button);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(128, 61, 862, 598);
		contentPane.add(layeredPane);

		idReaderLabel = new JLabel("����֤��");
		idReaderLabel.setFont(new Font("����", Font.PLAIN, 30));
		idReaderLabel.setBounds(311, 102, 158, 43);
		layeredPane.add(idReaderLabel);

		nameReaderLabel = new JLabel("����");
		nameReaderLabel.setFont(new Font("����", Font.PLAIN, 30));
		nameReaderLabel.setBounds(241, 171, 81, 32);
		layeredPane.add(nameReaderLabel);

		typeLabel = new JLabel("ְλ");
		typeLabel.setFont(new Font("����", Font.PLAIN, 30));
		typeLabel.setBounds(507, 171, 93, 32);
		layeredPane.add(typeLabel);

		sexLabel = new JLabel("�Ա�");
		sexLabel.setFont(new Font("����", Font.PLAIN, 30));
		sexLabel.setBounds(241, 218, 81, 38);
		layeredPane.add(sexLabel);

		passwordLabel = new JLabel("����");
		passwordLabel.setFont(new Font("����", Font.PLAIN, 30));
		passwordLabel.setBounds(507, 224, 81, 32);
		layeredPane.add(passwordLabel);

		showidReaderLabel = new JLabel();
		showidReaderLabel.setFont(new Font("����", Font.PLAIN, 30));
		showidReaderLabel.setBounds(491, 102, 146, 43);
		layeredPane.add(showidReaderLabel);
		showidReaderLabel.setText(LoginFrame.idReader);

		showNameReaderLabel = new JLabel("");
		showNameReaderLabel.setFont(new Font("����", Font.PLAIN, 30));
		showNameReaderLabel.setBounds(348, 171, 144, 32);
		layeredPane.add(showNameReaderLabel);

		showTypeLabel = new JLabel("");
		showTypeLabel.setFont(new Font("����", Font.PLAIN, 30));
		showTypeLabel.setBounds(604, 170, 137, 33);
		layeredPane.add(showTypeLabel);

		showSexLabel = new JLabel("");
		showSexLabel.setFont(new Font("����", Font.PLAIN, 30));
		showSexLabel.setBounds(355, 218, 137, 38);
		layeredPane.add(showSexLabel);

		showPasswordLabel = new JLabel("");
		showPasswordLabel.setFont(new Font("����", Font.PLAIN, 30));
		showPasswordLabel.setBounds(604, 222, 137, 34);
		layeredPane.add(showPasswordLabel);
		
		bookScrollPane = new JScrollPane(bookJtable);
		bookScrollPane.setBounds(197, 271, 576, 249);
		layeredPane.add(bookScrollPane);

		return_BookButton = new JButton(new ImageIcon("image/return.jpg"));
		return_BookButton.setBounds(401, 540, 123, 43);
		return_BookButton.setFont(new Font("����", Font.PLAIN, 30));
		return_BookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_borrow_book();
			}
		});
		layeredPane.add(return_BookButton);

		show_data();

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);
	}

	/**
	 * @return ��ʾ������Ϣ
	 * @param Reader
	 *            ���ߵ�����ģ��
	 * @param ReaderTools
	 *            ���ݿ����������ģ�͡�����
	 */
	private void show_data() {

		bookJtable = new JTable();
		bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		bookJtable.setRowHeight(54);

		defaultModel = (DefaultTableModel) bookJtable.getModel();
		defaultModel.setRowCount(0);
		defaultModel.setColumnIdentifiers(new Object[] { "���", "����", "�۸�", "����", "����", "������" });

		bookJtable.getTableHeader().setReorderingAllowed(false);
		bookJtable.setModel(defaultModel);

		bookJtable.getColumnModel().getColumn(0).setPreferredWidth(10);
		bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
		bookJtable.getColumnModel().getColumn(2).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(3).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(4).setPreferredWidth(10);
		bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);

		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();
		BorrowTools borrowtools = new BorrowTools();

		if (showidReaderLabel.getText() != null && !"".equals(showidReaderLabel.getText())) {
			reader.setIdReader(showidReaderLabel.getText());
		} else {
			JOptionPane.showMessageDialog(this, "��������߱��", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		List<Reader> readerlist = readerTools.ReaderData(reader.getIdReader());
		List<Book> booklist = borrowtools.BookData(reader.getIdReader());

		// Check the idReader

		if (readerlist.size() == 0) {
			JOptionPane.showMessageDialog(this, "���߱�Ŵ�����������ȷ�Ķ��߱�� ", "", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			for (Iterator<Reader> iterator = readerlist.iterator(); iterator.hasNext();) {
				Reader temp = (Reader) iterator.next();
				showNameReaderLabel.setText(temp.getNameReader());
				showTypeLabel.setText(temp.getType());
				showSexLabel.setText(temp.getSex());
				showPasswordLabel.setText(temp.getPassword());
			}
			for (Iterator<Book> iterator = booklist.iterator(); iterator.hasNext();) {
				Book temp = (Book) iterator.next();
				defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice() + "Ԫ",
						temp.getType(), temp.getAuthor(), temp.getPublisher() });
			}
		}
		bookScrollPane.setViewportView(bookJtable);
	}

	/**
	 * @return ɾ��������Ϣ
	 * @param Book
	 *            �鼮������ģ��
	 * @param BookTools
	 *            ���ݿ�������鼮ģ�͡�����
	 *
	 * @param LoginFrame.idReader
	 *            �ӵ�½������
	 * @param idbook
	 *            ��ѡ�еı����
	 */
	private void do_borrow_book() {

		row = bookJtable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ���鼮", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		BorrowTools borrowtools = new BorrowTools();
		String idbook = bookJtable.getValueAt(row, 0).toString();
		int i = borrowtools.ReturnBook(idbook);
		if (i == 1) {
			JOptionPane.showMessageDialog(this, "����ɹ�", "", JOptionPane.WARNING_MESSAGE);
			show_data();
			return;
		} else {
			JOptionPane.showMessageDialog(this, "����ʧ��", "", JOptionPane.WARNING_MESSAGE);
			show_data();
			return;
		}
	}

	public void CloseFrame() {
		super.dispose();
	}
}
