package ve.gob.fundelec.simlec.Services.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ve.gob.fundelec.simlec.Services.ServiceRequest;

/**
 * Created by Eukaris on 25/04/2017.
 */
@Module
public class ServiceModule {
    private String BASE_URL;

    public ServiceModule(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    @Provides
    @Singleton
    ServiceRequest getServiceRequest(Retrofit retrofit){
        return retrofit.create(ServiceRequest.class);
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient.Builder httpClient, Retrofit.Builder retrofitBuilder){
        return retrofitBuilder.client(httpClient.build()).build();
    }

    @Provides
    @Singleton
    Retrofit.Builder providesRetrofitBuilder(String baseUrl){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    OkHttpClient.Builder providesOkHttpClient(){
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    String providesBaseUrl(){
        return BASE_URL;
    }

}
