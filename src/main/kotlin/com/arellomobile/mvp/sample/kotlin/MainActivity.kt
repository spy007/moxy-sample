package com.arellomobile.mvp.sample.kotlin

import android.app.AlertDialog
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.arellomobile.mvp.presenter.ProvidePresenterTag
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), DialogView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var dialogPresenter: DialogPresenter

    var alertDialog: AlertDialog? = null

    @ProvidePresenterTag(presenterClass = DialogPresenter::class, type = PresenterType.GLOBAL)
    fun provideDialogPresenterTag(): String = "Hello"

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun provideDialogPresenter() = DialogPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootView.setOnClickListener { dialogPresenter.onShowDialogClick() }
    }

    override fun showDialog(s1: String?, s2: String?, s3: String?) {
        alertDialog = AlertDialog.Builder(this)
            .setTitle("Title")
            .setMessage(s1)
            .setOnDismissListener { dialogPresenter.onHideDialog() }
            .show()
    }

    override fun hideDialog() {
        alertDialog?.setOnDismissListener { }
        alertDialog?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()

        hideDialog()
    }
}