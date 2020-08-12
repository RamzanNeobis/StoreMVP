package ru.startandroid.develop.mystoremvpnew.EditActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import ru.startandroid.develop.mystoremvpnew.model.StoreRepository;
import ru.startandroid.develop.mystoremvpnew.model.Store;

public class EditPresenter extends AndroidViewModel implements EditContract.Presenter{

    private StoreRepository repository;
    LiveData<Store> store;

    public EditPresenter(@NonNull Application application) {
        super(application);
        repository = new StoreRepository(application);

    }

    @Override
    public void insert(Store store) {
        repository.insert(store);
    }

    @Override
    public void getItem(int id) {
        store =repository.getItem(id);
    }

    @Override
    public void update(Store store) {
        repository.update(store);
    }

    @Override
    public void delete(Store store) {
        repository.delete(store);
    }

    @Override
    public void save(byte[] imageInByte, String title, String description, double price, int quantity) {
        Store current =  new Store(imageInByte, title, description, price, quantity);

        if (this.store == null){
            insert(current);
        } else {
            Store temp = this.store.getValue();
            if (temp != null)
                current.setId(temp.getId());

            update(current);
        }

    }





}
