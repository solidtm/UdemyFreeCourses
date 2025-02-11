package com.solid.ufc.data.module

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        CoreDataModule::class
    ]
)
interface CoreDataComponent {

    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance app: Application): Builder
        fun build(): CoreDataComponent
    }
}