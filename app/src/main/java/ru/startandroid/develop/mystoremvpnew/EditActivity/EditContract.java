package ru.startandroid.develop.mystoremvpnew.EditActivity;

import ru.startandroid.develop.mystoremvpnew.model.Store;

public interface EditContract {

    interface Presenter{

        void insert(Store store);

        void getItem(int id);

        void update(Store store);

        void delete(Store store);

        void save(byte[] imageInByte, String title, String description, double price, int quantity);

    }



    interface View{
        void saveStore();

        void showAlertDialogButtonClicked();
    }
}
