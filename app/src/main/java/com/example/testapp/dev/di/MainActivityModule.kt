@file:Suppress("unused")

package com.example.testapp.dev.di

import androidx.lifecycle.ViewModel
import com.example.testapp.dev.di.annotation.FragmentScoped
import com.example.testapp.dev.di.annotation.ViewModelKey
import com.example.testapp.dev.ui.login.LoginFragment
import com.example.testapp.dev.ui.login.LoginViewModel
import com.example.testapp.dev.ui.todolist.TodoListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module(subcomponents = [
//    LoginFragmentSubcomponent::class
])
abstract class MainActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun bindLoginFragment(): LoginFragment

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TodoListViewModel::class)
    internal abstract fun bindTodoListViewModel(loginViewModel: TodoListViewModel): ViewModel

}


//@Module
//abstract class LoginFragmentModule {
//
//    //those bindings are not contributing to the parent Map :(
//
//    @Binds
//    @IntoMap
//    @FragmentKey(LoginFragment::class)
//    internal abstract fun bindLoginFragment(loginFragment: LoginFragment): Fragment
//
//    @Binds
//    @IntoMap
//    @FragmentKey(TodoListFragment::class)
//    internal abstract fun bindTodoListFragment(loginFragment: TodoListFragment): Fragment
//}
//
//@Subcomponent(modules = [
//    LoginFragmentModule::class
//])
//@FragmentScoped
//interface LoginFragmentSubcomponent : AndroidInjector<Fragment> {
//
//    @Subcomponent.Builder
//    abstract class Builder : AndroidInjector.Builder<Fragment>()
//}