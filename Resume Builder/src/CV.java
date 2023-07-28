package com.company;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

public class CV {
    private JPanel cvPanel;
    private JTextField name;
    private JTextField address;
    private JTextField contact;
    private JTextField skill1;
    private JTextField skill2;
    private JTextField skill3;
    private JTextField skill4;
    private JComboBox years;
    private JTextField college;
    private JTextField twelfth;
    private JTextField tenth;
    private JButton generate;
    private JTextField exp2;
    private JTextField certi;
    private JTextField lang;
    private JTextField hobbie;
    private JTextField sum;
    private JButton photo;
    private JLabel img;
    private JTextField location;
    JFrame frame = new JFrame();

    public CV() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(cvPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        photo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png");
                fileChooser.addChoosableFileFilter(filter);
                int rs = fileChooser.showSaveDialog(null);
                if (rs == JFileChooser.APPROVE_OPTION) {
                    File selectedImage = fileChooser.getSelectedFile();
                    location.setText(selectedImage.getAbsolutePath());
                    img.setIcon(resize(location.getText()));

                }
            }
        });

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText() == null || contact.getText() == null || address.getText() == null || contact.getText() == null || college.getText() == null || twelfth.getText() == null || tenth.getText() == null || sum.getText() == null || lang.getText() == null) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER ALL DETAILS TO GENERATE CV");
                } else {
                    try {
                        String nameOfFile = "D:\\cv\\mycv.pdf";
                        Document myDocument = new Document();
                        PdfWriter.getInstance(myDocument, new FileOutputStream(nameOfFile));
                        myDocument.open();
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(location.getText());
                        img.setAbsolutePosition(473f, 750f);
                        img.scaleAbsolute(80f, 70f);
                        PdfPTable table = new PdfPTable(2);
                        myDocument.add(img);
                        myDocument.add(new Paragraph(name.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 32, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("SUMMARY", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(sum.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("CONTACT DETAILS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(contact.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(address.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        //myDocument.add(new Paragraph(address.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7, BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("SKILLS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        table.setHeaderRows(1);
                        table.addCell(skill1.getText());
                        table.addCell(skill2.getText());
                        table.addCell(skill3.getText());
                        table.addCell(skill4.getText());
                        myDocument.add(table);
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("EDUCATION DETAILS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(college.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(twelfth.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(tenth.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("WORK EXPERIENCE", FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("" + years.getSelectedItem(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(exp2.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));

                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        //myDocument.add(new Paragraph("REFERENCES", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        // myDocument.add(new Paragraph("Available upon request", FontFactory.getFont(FontFactory.TIMES_BOLD, 6, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("CERTIFICATIONS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(certi.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("HOBBIES", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(hobbie.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("LANGUAGES", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph(lang.getText(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 7, BaseColor.DARK_GRAY)));
                        myDocument.close();
                        JOptionPane.showMessageDialog(null, "CV is successfully generated");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        });
    }

    public ImageIcon resize(String path) {
        ImageIcon myImg = new ImageIcon(path);
        Image image = myImg.getImage();
        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImage);
        return finalImage;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        cvPanel = new JPanel();
        cvPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(17, 4, new Insets(2, 2, 2, 2), 1, 1));
        cvPanel.setBackground(new Color(-12420494));
        cvPanel.setForeground(new Color(-13224394));
        final JLabel label1 = new JLabel();
        label1.setText("Skills");
        cvPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 8, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(329, 16), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Education");
        cvPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        college = new JTextField();
        cvPanel.add(college, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        skill3 = new JTextField();
        cvPanel.add(skill3, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        skill2 = new JTextField();
        cvPanel.add(skill2, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        skill1 = new JTextField();
        cvPanel.add(skill1, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tenth = new JTextField();
        cvPanel.add(tenth, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        twelfth = new JTextField();
        cvPanel.add(twelfth, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        years = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("no experience");
        defaultComboBoxModel1.addElement("1-2 years");
        defaultComboBoxModel1.addElement("2-4 years");
        defaultComboBoxModel1.addElement("4-6 years");
        defaultComboBoxModel1.addElement("6-8 years");
        defaultComboBoxModel1.addElement(">8 years");
        years.setModel(defaultComboBoxModel1);
        cvPanel.add(years, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        certi = new JTextField();
        cvPanel.add(certi, new com.intellij.uiDesigner.core.GridConstraints(15, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Name");
        cvPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        name = new JTextField();
        cvPanel.add(name, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Summary");
        cvPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 16), null, 0, false));
        sum = new JTextField();
        cvPanel.add(sum, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Hobbies");
        cvPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Languages");
        cvPanel.add(label6, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        hobbie = new JTextField();
        cvPanel.add(hobbie, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lang = new JTextField();
        cvPanel.add(lang, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        photo = new JButton();
        photo.setText("Select photograph");
        cvPanel.add(photo, new com.intellij.uiDesigner.core.GridConstraints(15, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        skill4 = new JTextField();
        cvPanel.add(skill4, new com.intellij.uiDesigner.core.GridConstraints(8, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        exp2 = new JFormattedTextField();
        cvPanel.add(exp2, new com.intellij.uiDesigner.core.GridConstraints(10, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Address");
        cvPanel.add(label7, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        address = new JTextField();
        cvPanel.add(address, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Contact");
        cvPanel.add(label8, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contact = new JTextField();
        cvPanel.add(contact, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Experience");
        cvPanel.add(label9, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        generate = new JButton();
        generate.setText("Generate Resume");
        cvPanel.add(generate, new com.intellij.uiDesigner.core.GridConstraints(16, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        location = new JTextField();
        cvPanel.add(location, new com.intellij.uiDesigner.core.GridConstraints(15, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        img = new JLabel();
        img.setText("");
        cvPanel.add(img, new com.intellij.uiDesigner.core.GridConstraints(14, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Certifications");
        cvPanel.add(label10, new com.intellij.uiDesigner.core.GridConstraints(11, 2, 3, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(329, 16), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return cvPanel;
    }


}
