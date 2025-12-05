package modul08.controller;

import modul08.model.PersegiPanjangModel;
import modul08.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Menambahkan ActionListener pada tombol hitung
        this.view.LuasListener(new LuasListener());
        this.view.KelilingListener(new KelilingListener());
        // Menambahkan ActionListener pada tombol Reset
        this.view.ResetListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.reset();
                view.resetFields();
            }
        });
    }

    class LuasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungLuas();
          
                
                double hasilLuas = model.getLuas();
                view.setHasilLuas(hasilLuas);

        

            } catch (NumberFormatException ex) {
                view.tampillkanPesanEror("Input tidak valid! Harap masukkan angka.");
            }
        }
    }

    class KelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungKeliling();
                

                double hasilKeliling = model.getKeliling();
                view.setHasilKeliling(hasilKeliling);

            } catch (NumberFormatException ex) {
                view.tampillkanPesanEror("Input tidak valid! Harap masukkan angka.");
            }
        }
    }


}

