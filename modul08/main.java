package modul08;
import modul08.model.PersegiPanjangModel;
import modul08.view.PersegiPanjangView;
import modul08.controller.PersegiPanjangController;

public class main {
    public static void main(String[] args) {
        PersegiPanjangModel model = new PersegiPanjangModel();
        PersegiPanjangView view = new PersegiPanjangView();
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        view.setVisible(true);
    }
}
