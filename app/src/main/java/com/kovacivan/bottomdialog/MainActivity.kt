package com.kovacivan.bottomdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kovacivan.bottomdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BottomDialogListener {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.button.setOnClickListener {
			BottomDialog(this, this, binding.root)
				.title("Do you want to delete or edit this item?")
				.topButtonText("Delete")
				.bottomButtonText("Edit")
				.cancelButtonText("Cancel")
				.showBottomDialog()
		}
	}

	override fun topButtonClicked() {
		Snackbar.make(
			binding.root,
			"Top button clicked",
			Snackbar.LENGTH_SHORT
		).show()
	}

	override fun bottomButtonClicked() {
		Snackbar.make(
			binding.root,
			"Bottom button clicked",
			Snackbar.LENGTH_SHORT
		).show()
	}

	override fun cancelButtonClicked() {
		Snackbar.make(
			binding.root,
			"Cancel button clicked",
			Snackbar.LENGTH_SHORT
		).show()
	}
}