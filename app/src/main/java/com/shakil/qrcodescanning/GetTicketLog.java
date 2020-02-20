package com.shakil.qrcodescanning;

import android.os.AsyncTask;

public class GetTicketLog {
    private onLoadCompleted onLoadCompleted = null;

    public interface onLoadCompleted {
        void onComplete();
    }

    public void getTicketLog(onLoadCompleted onLoadCompleted){
        this.onLoadCompleted = onLoadCompleted;
        new BackgroundDataLoad().execute();
    }

    private class BackgroundDataLoad extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {
            getLog();
            return "done";
        }

        @Override
        protected void onPostExecute(String result) {
            if(onLoadCompleted != null) onLoadCompleted.onComplete();
        }

    }

    private void getLog() {
    }
}
