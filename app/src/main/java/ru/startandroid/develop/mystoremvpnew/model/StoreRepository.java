package ru.startandroid.develop.mystoremvpnew.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StoreRepository {

    private StoreDao storeDao;
    private LiveData<List<Store>> allNotes;

    public StoreRepository(Application application) {
        StoreDatabase database = StoreDatabase.getInstance(application);
        storeDao = database.storeDao();
        allNotes = storeDao.getAllNotes();
    }

    public void insert(Store store) {
        new InsertNoteAsyncTask(storeDao).execute(store);
    }

    public LiveData<Store> getItem(int id){
        return storeDao.getItem(id);
    }

    public void update(Store store) {
        new UpdateNoteAsyncTask(storeDao).execute(store);
    }

    public void delete(Store store) {
        new DeleteNoteAsyncTask(storeDao).execute(store);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesNoteAsyncTask(storeDao).execute();
    }

    public LiveData<List<Store>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Store, Void, Void> {
        private StoreDao storeDao;

        private InsertNoteAsyncTask(StoreDao storeDao) {
            this.storeDao= storeDao;
        }

        @Override
        protected Void doInBackground(Store... items) {
            storeDao.insert(items[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Store, Void, Void> {
        private StoreDao storeDao;

        private UpdateNoteAsyncTask(StoreDao storeDao) {
            this.storeDao = storeDao;
        }

        @Override
        protected Void doInBackground(Store... stores) {
            storeDao.update(stores[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Store, Void, Void> {
        private StoreDao storeDao;

        private DeleteNoteAsyncTask(StoreDao storeDao) {
            this.storeDao = storeDao;
        }

        @Override
        protected Void doInBackground(Store... stores) {
            storeDao.delete(stores[0]);
            return null;
        }
    }

    private static class DeleteAllNotesNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private StoreDao storeDao;

        private DeleteAllNotesNoteAsyncTask(StoreDao storeDao) {
            this.storeDao = storeDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            storeDao.deleteAllNotes();
            return null;
        }
    }

}
