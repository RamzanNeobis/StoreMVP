package ru.startandroid.develop.mystoremvpnew.main;

import ru.startandroid.develop.mystoremvpnew.model.Store;

public interface MainContract {

    interface Presenter {

        void insert(Store store);

        void update(Store store);

        void delete(Store store);

        void deleteAllNotes();


    }

    interface View {


    }
}
