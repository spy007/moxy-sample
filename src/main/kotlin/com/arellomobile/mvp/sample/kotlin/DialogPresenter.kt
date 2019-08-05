package com.arellomobile.mvp.sample.kotlin

import com.arellomobile.mvp.MvpPresenter

/**
 * Date: 03.03.2016
 * Time: 11:22
 * @author Yuri Shmakov
 */
//@InjectViewState
class DialogPresenter : MvpPresenter<DialogView>() {

    fun onShowDialogClick() {
        val s1: String? = "s1"
        val s2: String? = "s2"
        val s3: String? = "s3"
        viewState.showDialog(s1, s2, s3)
    }

    fun onHideDialog() {
        viewState.hideDialog()
    }
}
