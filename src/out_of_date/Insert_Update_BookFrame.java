package out_of_date;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Author;
import model.Book;
import model.Publisher;
import sqlTools.AuthorTools;
import sqlTools.BookTools;
import sqlTools.PublisherTools;

public class Insert_Update_BookFrame extends JFrame {

	/**
	 * Java�����л�������ͨ��������ʱ�ж����serialVersionUID����֤�汾һ���Ե�
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField idBooktextField;
	private JTextField nameBooktextField;
	private JTextField priceField;
	private JTextField typetextField;
	private JTextField authortextField;
	private JTextField publishertextField;	
	private JTextField authorWorkplaceField;
	private JTextField publisherAddressField;

	private JLabel idBookLabel;
	private JLabel nameBookLabel;
	private JLabel priceLabel;
	private JLabel typeLabel;
	private JLabel authorLabel;
	private JLabel publisherLabel;
	private JLabel authorWorkplaceLabel;
	private JLabel publisherAddressLabel;
	
	private JButton insertButton;
	private JButton updateButton;
/*	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Update_BookFrame frame = new Insert_Update_BookFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Insert_Update_BookFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idBookLabel = new JLabel("�鼮���");
		idBookLabel.setBounds(82, 25, 81, 21);
		contentPane.add(idBookLabel);
		
		nameBookLabel = new JLabel("����");
		nameBookLabel.setBounds(82, 77, 81, 21);
		contentPane.add(nameBookLabel);
		
		priceLabel = new JLabel("�۸�");
		priceLabel.setBounds(67, 124, 81, 21);
		contentPane.add(priceLabel);
		
		typeLabel = new JLabel("����");
		typeLabel.setBounds(82, 181, 81, 21);
		contentPane.add(typeLabel);
		
		authorLabel = new JLabel("����");
		authorLabel.setBounds(82, 234, 81, 21);
		contentPane.add(authorLabel);
		
		publisherLabel = new JLabel("������");
		publisherLabel.setBounds(67, 288, 81, 21);
		contentPane.add(publisherLabel);
		
		
		idBooktextField = new JTextField();
		idBooktextField.setBounds(218, 22, 96, 27);
		contentPane.add(idBooktextField);
		idBooktextField.setColumns(10);
		
		nameBooktextField = new JTextField();
		nameBooktextField.setBounds(218, 74, 96, 27);
		contentPane.add(nameBooktextField);
		nameBooktextField.setColumns(10);
	
		
		priceField = new JTextField();
		priceField.setBounds(218, 116, 96, 27);
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		typetextField = new JTextField();
		typetextField.setBounds(218, 178, 96, 27);
		contentPane.add(typetextField);
		typetextField.setColumns(10);
		
		authortextField = new JTextField();
		authortextField.setBounds(218, 231, 96, 27);
		contentPane.add(authortextField);
		authortextField.setColumns(10);
		
		publishertextField = new JTextField();
		publishertextField.setBounds(218, 285, 96, 27);
		contentPane.add(publishertextField);
		publishertextField.setColumns(10);
		
		insertButton = new JButton("����");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_AddBook();
			}
		});
		insertButton.setBounds(82, 373, 106, 37);
		contentPane.add(insertButton);
		
		updateButton = new JButton("����");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_UpdateBook();
			}
		});
		updateButton.setBounds(271, 373, 106, 37);
		contentPane.add(updateButton);
		
		authorWorkplaceLabel = new JLabel("���ߵ�λ");
		authorWorkplaceLabel.setBounds(404, 234, 81, 21);
		contentPane.add(authorWorkplaceLabel);
		
		publisherAddressLabel = new JLabel("�������ַ");
		publisherAddressLabel.setBounds(404, 288, 112, 21);
		contentPane.add(publisherAddressLabel);
		
		authorWorkplaceField = new JTextField();
		authorWorkplaceField.setBounds(531, 231, 104, 27);
		contentPane.add(authorWorkplaceField);
		authorWorkplaceField.setColumns(10);
		
		publisherAddressField = new JTextField();
		publisherAddressField.setBounds(531, 285, 104, 27);
		contentPane.add(publisherAddressField);
		publisherAddressField.setColumns(10);

	}

	/**
	 * �������ݿ⽨��ʱ��Book��author��publisher�ֶηֱ����Author��Publisher��
	 * ��˴�����дʱ��Ӧ���ȸ���Author��Publisher��
	 * @return ���������鼮�Ĳ���
	 * @param Book �鼮������ģ��
	 * @param Author ���ߵ�����ģ��
	 * @param Publisher �����������ģ��
	 * @param BookTools ���ݿ�������鼮����ģ�͡�����
	 * @param AuthorTools ���ݿ��������������ģ�͡�����
	 * @param PublisherTools ���ݿ����������������ģ�͡�����
	 */
	protected void do_insertButton_AddBook() {
		// TODO Auto-generated method stub
		BookTools bookTools = new BookTools();
		Book book = new Book();
		
		Author author = new Author();
		AuthorTools authorTools = new AuthorTools();
		
		Publisher publisher= new Publisher();
		PublisherTools publisherTools = new PublisherTools();
		
		if ( idBooktextField.getText() != null && !"".equals(idBooktextField.getText()) 
				&& nameBooktextField.getText() != null && !"".equals(nameBooktextField.getText())
				&& priceField.getText() != null && !"".equals(priceField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& authortextField.getText() != null && !"".equals(authortextField.getText())
				&& publishertextField.getText() != null && !"".equals(publishertextField.getText())
				&& authorWorkplaceField.getText()!= null && !"".equals(authorWorkplaceField.getText())
				&& publisherAddressField.getText() != null && !"".equals(publisherAddressField.getText())) {
			book.setIdBook(idBooktextField.getText());
			book.setNameBook(nameBooktextField.getText());
			book.setPrice(Integer.parseInt(priceField.getText()));
			book.setType(typetextField.getText());
			book.setAuthor(authortextField.getText());
			book.setPublisher(publishertextField.getText());
			author.setName(authortextField.getText());
			author.setWorkplace(authorWorkplaceField.getText());
			publisher.setName(publishertextField.getText());
			publisher.setAddress(publisherAddressField.getText());
			int j = publisherTools.AddPublisher(publisher);
			int k = authorTools.AddAuthor(author);
			int i = bookTools.AddBook(book);
			if ( i == 1 && j==1 && k==1) {
	            JOptionPane.showMessageDialog(getContentPane(), "�ɹ�����ͼ����Ϣ��", "", JOptionPane.WARNING_MESSAGE);
	            return;
			} else {
	            JOptionPane.showMessageDialog(getContentPane(), "����ͼ����Ϣʧ�ܣ�", "", JOptionPane.WARNING_MESSAGE);
	            return;
			}
		} else {
            JOptionPane.showMessageDialog(getContentPane(), "��������������", "", JOptionPane.WARNING_MESSAGE);
            return;
		}
	}

	/**
	 * �������ݿ⽨��ʱ��Book��author��publisher�ֶηֱ����Author��Publisher��
	 * ��˴�����дʱ��Ӧ���ȸ���Author��Publisher��
	 * @return ���и����鼮�Ĳ���
	 * @param Book �鼮������ģ��
	 * @param Author ���ߵ�����ģ��
	 * @param Publisher �����������ģ��
	 * @param BookTools ���ݿ�������鼮����ģ�͡�����
	 * @param AuthorTools ���ݿ��������������ģ�͡�����
	 * @param PublisherTools ���ݿ����������������ģ�͡�����
	 */
	protected void do_updateButton_UpdateBook() {
		// TODO Auto-generated method stub
		BookTools bookTools = new BookTools();
		Book book = new Book();
		
		Author author = new Author();
		AuthorTools authorTools = new AuthorTools();
		
		Publisher publisher= new Publisher();
		PublisherTools publisherTools = new PublisherTools();
		
		if ( idBooktextField.getText() != null && !"".equals(idBooktextField.getText()) 
				&& nameBooktextField.getText() != null && !"".equals(nameBooktextField.getText())
				&& priceField.getText() != null && !"".equals(priceField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& authortextField.getText() != null && !"".equals(authortextField.getText())
				&& publishertextField.getText() != null && !"".equals(publishertextField.getText())
				&& authorWorkplaceField.getText()!= null && !"".equals(authorWorkplaceField.getText())
				&& publisherAddressField.getText() != null && !"".equals(publisherAddressField.getText())) {
			book.setIdBook(idBooktextField.getText());
			book.setNameBook(nameBooktextField.getText());
			book.setPrice(Integer.parseInt(priceField.getText()));
			book.setType(typetextField.getText());
			book.setAuthor(authortextField.getText());
			book.setPublisher(publishertextField.getText());
			author.setName(authortextField.getText());
			author.setWorkplace(authorWorkplaceField.getText());
			publisher.setName(publishertextField.getText());
			publisher.setAddress(publisherAddressField.getText());
			int j = publisherTools.UpdatePublisher(publisher);
			int k = authorTools.UpdateAuthor(author);
			int i = bookTools.UpdateBook(book);
			if ( i == 1 && j==1 && k==1) {
	            JOptionPane.showMessageDialog(getContentPane(), "�ɹ�����ͼ����Ϣ��", "", JOptionPane.WARNING_MESSAGE);
	            return;
			} else {
	            JOptionPane.showMessageDialog(getContentPane(), "����ͼ����Ϣʧ�ܣ�", "", JOptionPane.WARNING_MESSAGE);
	            return;
			}
		} else {
            JOptionPane.showMessageDialog(getContentPane(), "��������������", "", JOptionPane.WARNING_MESSAGE);
            return;
		}
	}
}
