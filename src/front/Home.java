package front;

import javax.swing.*;
import process.bank_process;

public class Home extends JFrame{
    private JLabel data_bankLabel;

    public Home(bank_process proceso ){
        data_bankLabel.setVisible(true);
        data_bankLabel.setSize(200,200);
        data_bankLabel.setText(proceso.get_bank_info());
    }
}
