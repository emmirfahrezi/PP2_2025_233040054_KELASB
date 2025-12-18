package modul10;

import javax.swing.*;

import modul10.controller.MahasiswaController;
import modul10.model.MahasiswaModel;
import modul10.view.MahasiswaView;

public class MahasiswaApp {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           
            MahasiswaView view = new MahasiswaView();
            MahasiswaModel model = new MahasiswaModel();
            MahasiswaController controller = new MahasiswaController(view, model);
        });
    }
}
