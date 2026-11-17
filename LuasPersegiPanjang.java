import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

// 1. KELAS KONTAINER TINGKAT ATAS: JFrame
public class LuasPersegiPanjang extends JFrame implements ActionListener, FocusListener {

    // 3. KELAS KOMPONEN ATOM: JLabel, JTextField, JButton, JComboBox
    private JLabel labelJudul, labelPanjang, labelLebar, labelSatuan, labelHasil;
    private JTextField textPanjang, textLebar;
    private JComboBox<String> comboSatuan;
    private JButton btnHitung, btnReset;

    // 2. KELAS KONTAINER MENENGAH: JPanel
    private JPanel panelUtama, panelInput, panelTombol, panelBawah;

    public LuasPersegiPanjang() {
        super("Aplikasi Hitung Luas Persegi Panjang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 280);
        setLocationRelativeTo(null);

        // Panel utama dengan jarak tepi (padding) agar tampilan rapi saat di-screenshot
        panelUtama = new JPanel();
        // 4. KELAS TATA LETAK (Ke-1): BorderLayout
        panelUtama.setLayout(new BorderLayout(10, 10));
        panelUtama.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Bagian Atas (Judul)
        labelJudul = new JLabel("KALKULATOR LUAS PERSEGI PANJANG", SwingConstants.CENTER);
        labelJudul.setFont(new Font("SansSerif", Font.BOLD, 14));
        panelUtama.add(labelJudul, BorderLayout.NORTH);

        // Bagian Tengah (Form Input)
        // 4. KELAS TATA LETAK (Ke-2): GridLayout
        panelInput = new JPanel(new GridLayout(3, 2, 8, 10));

        labelPanjang = new JLabel("Panjang:");
        textPanjang = new JTextField();

        labelLebar = new JLabel("Lebar:");
        textLebar = new JTextField();

        labelSatuan = new JLabel("Satuan:");
        String[] daftarSatuan = {"cm", "m", "mm"};
        comboSatuan = new JComboBox<>(daftarSatuan);

        panelInput.add(labelPanjang);
        panelInput.add(textPanjang);
        panelInput.add(labelLebar);
        panelInput.add(textLebar);
        panelInput.add(labelSatuan);
        panelInput.add(comboSatuan);

        panelUtama.add(panelInput, BorderLayout.CENTER);

        // Bagian Bawah (Tombol & Hasil)
        panelBawah = new JPanel(new BorderLayout(5, 8));

        // 4. KELAS TATA LETAK (Ke-3): FlowLayout
        panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnHitung = new JButton("Hitung Luas");
        btnReset = new JButton("Reset");

        panelTombol.add(btnHitung);
        panelTombol.add(btnReset);

        labelHasil = new JLabel("Hasil Luas: 0 cm²", SwingConstants.CENTER);
        labelHasil.setFont(new Font("SansSerif", Font.BOLD, 13));

        panelBawah.add(panelTombol, BorderLayout.NORTH);
        panelBawah.add(labelHasil, BorderLayout.SOUTH);

        panelUtama.add(panelBawah, BorderLayout.SOUTH);
        add(panelUtama);

        // 5A. PENDENGAR PERISTIWA (Antarmuka / Interface): ActionListener & FocusListener
        btnHitung.addActionListener(this);
        btnReset.addActionListener(this);
        textPanjang.addFocusListener(this);
        textLebar.addFocusListener(this);

        // 5B. PENDENGAR PERISTIWA (Kelas Adaptor / Adapter Class): KeyAdapter
        // Menekan tombol ENTER di kolom lebar otomatis menjalankan perhitungan
        textLebar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    hitungLuas();
                }
            }
        });

        // 5C. PENDENGAR PERISTIWA (Kelas Adaptor / Adapter Class): MouseAdapter
        // Mengubah warna tombol saat kursor mouse diarahkan ke tombol Hitung
        btnHitung.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnHitung.setBackground(new Color(173, 216, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnHitung.setBackground(UIManager.getColor("Button.background"));
            }
        });
    }

    private void hitungLuas() {
        try {
            double p = Double.parseDouble(textPanjang.getText());
            double l = Double.parseDouble(textLebar.getText());
            double luas = p * l;
            String satuan = (String) comboSatuan.getSelectedItem();
            labelHasil.setText("Hasil Luas: " + luas + " " + satuan + "²");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Masukkan angka yang valid pada kolom Panjang dan Lebar!",
                "Input Tidak Valid",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void resetForm() {
        textPanjang.setText("");
        textLebar.setText("");
        comboSatuan.setSelectedIndex(0);
        labelHasil.setText("Hasil Luas: 0 cm²");
        textPanjang.requestFocus();
    }

    // Override metode dari antarmuka ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHitung) {
            hitungLuas();
        } else if (e.getSource() == btnReset) {
            resetForm();
        }
    }

    // Override metode dari antarmuka FocusListener
    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            ((JTextField) e.getSource()).setBackground(new Color(230, 242, 255));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            ((JTextField) e.getSource()).setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LuasPersegiPanjang().setVisible(true));
    }
}