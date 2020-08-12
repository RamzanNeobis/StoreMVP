package ru.startandroid.develop.mystoremvpnew.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.startandroid.develop.mystoremvpnew.model.Store;
import ru.startandroid.develop.mystoremvpnew.model.StoreRepository;

public class MainPresenter extends AndroidViewModel implements MainContract.Presenter {

    private StoreRepository repository;
    private LiveData<List<Store>> allNotes;

    public MainPresenter(@NonNull Application application) {
        super(application);
        repository = new StoreRepository(application);
        allNotes = repository.getAllNotes();

    }


    public LiveData<List<Store>> getAllNotes() {
        return allNotes;
    }

    @Override
    public void insert(Store store) {
        repository.insert(store);
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
    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }
}
