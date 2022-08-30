package com.example.redditapp.di.modules

import androidx.room.Room
import com.example.redditapp.service.constants.RedditConstants
import com.example.redditapp.service.repository.RedditRepository
import com.example.redditapp.service.repository.local.RedditDAO
import com.example.redditapp.service.repository.local.RedditDatabase
import com.example.redditapp.service.repository.remote.RedditService
import com.example.redditapp.service.repository.remote.RetrofitClient
import com.example.redditapp.ui.adapter.RedditAdapter
import com.example.redditapp.ui.viewmodel.RedditListViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val redditDatabaseModules = module {
    single<RedditDatabase> {
        Room.databaseBuilder(get(), RedditDatabase::class.java, RedditConstants.BUILDER.DB_NAME)
            .allowMainThreadQueries()
            .build()
    }
    single<RedditDAO> { get<RedditDatabase>().redditDAO }
}

val redditWebClientModules = module {
    single<OkHttpClient> {
        RetrofitClient.getHttpClientInstance()
    }
    single<Retrofit> {
        RetrofitClient.getRetrofitInstance(get())
    }
    single<RedditService> { get<Retrofit>().create(RedditService::class.java) }
}

val redditRepositoryModules = module {
    single<RedditRepository> { RedditRepository(get(), get(), androidContext()) }
}

val redditViewModelModules = module {
    viewModel<RedditListViewModel> { RedditListViewModel(get()) }
}

val redditAdapterModules = module {
    factory { RedditAdapter(androidContext()) }
}
