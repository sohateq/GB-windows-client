package retrofitModel.repo;

import retrofitModel.api.IDataSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TalosRepo{

    private static TalosRepo singleton = null;
    private IDataSource api;

    public TalosRepo() {
        this.api = createAdapter();
    }

    private IDataSource createAdapter() {
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("http://35.237.102.95:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return adapter.create(IDataSource.class);
    }

    public static TalosRepo getSingleton() {
        if(singleton == null) {
            singleton = new TalosRepo();
        }
        return singleton;
    }

    public IDataSource getApi() {
        return api;
    }
}
