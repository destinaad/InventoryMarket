import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InventoryGUI extends JFrame {
    private ArrayList<Barang> daftarBarang;
    private DefaultListModel<String> listModel;
    private JList<String> barangList;

    public InventoryGUI() {
        daftarBarang = new ArrayList<>();
        listModel = new DefaultListModel<>();

        setTitle("Manajemen Inventaris Barang");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JLabel namaLabel = new JLabel("Nama Barang:");
        JTextField namaField = new JTextField();
        JLabel hargaLabel = new JLabel("Harga:");
        JTextField hargaField = new JTextField();
        JLabel stokLabel = new JLabel("Stok:");
        JTextField stokField = new JTextField();
        JButton tambahButton = new JButton("Tambah");

        inputPanel.add(namaLabel);
        inputPanel.add(namaField);
        inputPanel.add(hargaLabel);
        inputPanel.add(hargaField);
        inputPanel.add(stokLabel);
        inputPanel.add(stokField);
        inputPanel.add(new JLabel());
        inputPanel.add(tambahButton);

        add(inputPanel, BorderLayout.NORTH);

        // Panel Daftar Barang
        barangList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(barangList);
        add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton sortNamaButton = new JButton("Sort by Nama");
        JButton sortHargaButton = new JButton("Sort by Harga");

        buttonPanel.add(sortNamaButton);
        buttonPanel.add(sortHargaButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event Handling
        tambahButton.addActionListener(e -> {
            String nama = namaField.getText();
            double harga = Double.parseDouble(hargaField.getText());
            int stok = Integer.parseInt(stokField.getText());

            Barang barang = new Barang(nama, harga, stok);
            daftarBarang.add(barang);
            listModel.addElement(barang.toString());

            namaField.setText("");
            hargaField.setText("");
            stokField.setText("");
        });

        sortNamaButton.addActionListener(e -> {
            daftarBarang.sort((a, b) -> a.getNama().compareTo(b.getNama()));
            updateList();
        });

        sortHargaButton.addActionListener(e -> {
            daftarBarang.sort((a, b) -> Double.compare(a.getHarga(), b.getHarga()));
            updateList();
        });
    }

    private void updateList() {
        listModel.clear();
        for (Barang barang : daftarBarang) {
            listModel.addElement(barang.toString());
        }
    }
}