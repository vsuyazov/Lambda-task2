public class Worker {

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public  interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskDoneListener callback;

    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        int fault = 33;
        for (int i = 0; i < 100; i++) {
            if ((i + 1)!= fault){
                callback.onDone("Task " + (i + 1) + " is done");
            }
            else {
                errorCallback.onError("ERROR! Task " + (i + 1) + " is not done.");
            }
        }
    }
}
