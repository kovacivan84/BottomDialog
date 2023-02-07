package com.kovacivan.bottomdialog

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class BottomDialog(activity: Activity, private val listener: BottomDialogListener, private val view: ViewGroup) {

	private var bottomDialogModel = BottomDialogModel()

	private val dialogView = activity.layoutInflater.inflate(R.layout.bottom_dialog_layout, null)
	private val dialogViewParent = dialogView.findViewById<ConstraintLayout>(R.id.parentContainer)
	private val dialogContainer = dialogView.findViewById<LinearLayout>(R.id.dialogContainer)
	private val overlayView = dialogView.findViewById<View>(R.id.overlay)
	private val titleView = dialogView.findViewById<TextView>(R.id.title)
	private val topButtonView = dialogView.findViewById<TextView>(R.id.topButton)
	private val bottomButtonView = dialogView.findViewById<TextView>(R.id.bottomButton)
	private val cancelButtonView = dialogView.findViewById<TextView>(R.id.cancelButton)

	/**
	 * Set the duration of bottom dialog fly up and down animation
	 */
	fun animationDuration(animationDuration: Long): BottomDialog {
		bottomDialogModel.animationDuration = animationDuration
		return this
	}

	/**
	 * Listener for button click
	 *
	 * @return String of the button text that you set previously
	 */
	var onItemClick: ((String) -> Unit)? = null

	/**
	 * Set title text
	 */
	fun title(title: String): BottomDialog {
		bottomDialogModel.titleText = title
		return this
	}

	/**
	 * Change title text size
	 *
	 * Default value is 12
	 */
	fun titleTextSize(titleTextSize: Int): BottomDialog {
		bottomDialogModel.titleTextSize = titleTextSize
		return this
	}

	/**
	 * Change title text color
	 *
	 * Default is black
	 */
	fun titleTextColor(titleTextColor: Int): BottomDialog {
		bottomDialogModel.titleTextColor = titleTextColor
		return this
	}

	/**
	 * Change title typeface
	 */
	fun titleTypeface(titleTypeface: Int): BottomDialog {
		bottomDialogModel.titleTypeface = titleTypeface
		return this
	}

	/**
	 * Set text for the top button
	 */
	fun topButtonText(topButtonText: String): BottomDialog {
		bottomDialogModel.topButtonText = topButtonText
		return this
	}

	/**
	 * Change top button text size
	 */
	fun topButtonTextSize(topButtonTextSize: Int): BottomDialog {
		bottomDialogModel.topButtonTextSize = topButtonTextSize
		return this
	}

	/**
	 * Change top button text color
	 */
	fun topButtonTextColor(topButtonTextColor: Int): BottomDialog {
		bottomDialogModel.topButtonTextColor = topButtonTextColor
		return this
	}

	/**
	 * Change top button typeface
	 */
	fun topButtonTypeface(topButtonTypeface: Int): BottomDialog {
		bottomDialogModel.topButtonTypeface = topButtonTypeface
		return this
	}

	/**
	 * Hide top button
	 *
	 * Default is false
	 */
	fun hideTopButton(shouldHideTopButton: Boolean): BottomDialog {
		bottomDialogModel.hideTopButton = shouldHideTopButton
		return this
	}

	/**
	 * Set text for the bottom button
	 */
	fun bottomButtonText(bottomButtonText: String): BottomDialog {
		bottomDialogModel.bottomButtonText = bottomButtonText
		return this
	}

	/**
	 * Change bottom button text size
	 */
	fun bottomButtonTextSize(bottomButtonTextSize: Int): BottomDialog {
		bottomDialogModel.bottomButtonTextSize = bottomButtonTextSize
		return this
	}

	/**
	 * Change bottom button text color
	 */
	fun bottomButtonTextColor(bottomButtonTextColor: Int): BottomDialog {
		bottomDialogModel.bottomButtonTextColor = bottomButtonTextColor
		return this
	}

	/**
	 * Change bottom button typeface
	 */
	fun bottomButtonTypeface(bottomButtonTypeface: Int): BottomDialog {
		bottomDialogModel.bottomButtonTypeface = bottomButtonTypeface
		return this
	}

	/**
	 * Set text for the cancel button. It is intended to be
	 * used as cancel button
	 *
	 * Default is Cancel
	 */
	fun cancelButtonText(cancelButtonText:String): BottomDialog {
		bottomDialogModel.cancelButtonText = cancelButtonText
		return this
	}

	/**
	 * Change cancel button text size
	 */
	fun cancelButtonTextSize(cancelButtonTextSize: Int): BottomDialog {
		bottomDialogModel.cancelButtonTextSize = cancelButtonTextSize
		return this
	}

	/**
	 * Change cancel button text color
	 */
	fun cancelButtonTextColor(cancelButtonTextColor: Int): BottomDialog {
		bottomDialogModel.cancelButtonTextColor = cancelButtonTextColor
		return this
	}

	/**
	 * Change bottom button typeface
	 */
	fun cancelButtonTypeface(cancelButtonTypeface: Int): BottomDialog {
		bottomDialogModel.cancelButtonTypeface = cancelButtonTypeface
		return this
	}

	/**
	 * Set transparent overlay over your layout
	 */
	fun backgroundOverlay(backgroundOverlayState: Boolean): BottomDialog {
		bottomDialogModel.backgroundOverlayState = backgroundOverlayState
		return this
	}

	/**
	 * Set the percentage of background overlay
	 *
	 * IMPORTANT: Use 0.0f to 1.0f values. Any other value will cause crash
	 *
	 * Default is 0.2f
	 */
	fun backgroundOverlayTransparencyPercentage(backgroundOverlayTransparencyPercentage: Float): BottomDialog {
		bottomDialogModel.backgroundOverlayTransparencyPercentage = backgroundOverlayTransparencyPercentage
		return this
	}

	/**
	 * Change color of background overlay
	 *
	 * Default is black
	 */
	fun backgroundOverlayColor(backgroundOverlayColor: Int): BottomDialog {
		bottomDialogModel.backgroundOverlayColor = backgroundOverlayColor
		return this
	}

	/**
	 * Hides bottom dialog on background click
	 *
	 * Default is true
	 */
	fun hideOnBackgroundClick(hideOnBackgroundClick: Boolean): BottomDialog {
		bottomDialogModel.hideOnBackgroundClick = hideOnBackgroundClick
		return this
	}

	/**
	 * Takes all the parameters and displays bottom dialog
	 *
	 * IMPORTANT: It has to be called as the last function
	 */
	fun showBottomDialog(): BottomDialog {

		view.addView(dialogView)
		showBottomDialogView()

		// Overlay parameters
		if (bottomDialogModel.backgroundOverlayState) {
			overlayView.setBackgroundColor(bottomDialogModel.backgroundOverlayColor)
			overlayView.alpha = bottomDialogModel.backgroundOverlayTransparencyPercentage
		}

		if (bottomDialogModel.hideOnBackgroundClick) {
			overlayView.setOnClickListener {
				hideBottomDialogView()
			}
		}

		// Title parameters
		titleView.text = bottomDialogModel.titleText
		titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, bottomDialogModel.titleTextSize.toFloat())
		titleView.setTextColor(bottomDialogModel.titleTextColor)
		titleView.setTypeface(
			titleView.typeface,
			bottomDialogModel.titleTypeface
		)

		// Top button parameters
		if (bottomDialogModel.hideTopButton) {
			topButtonView.visibility = View.GONE
		} else {
			topButtonView.visibility = View.VISIBLE
			topButtonView.text = bottomDialogModel.topButtonText
			topButtonView.setTextSize(TypedValue.COMPLEX_UNIT_SP, bottomDialogModel.topButtonTextSize.toFloat())
			topButtonView.setTextColor(bottomDialogModel.topButtonTextColor)
			topButtonView.setTypeface(
				topButtonView.typeface,
				bottomDialogModel.topButtonTypeface
			)
			topButtonView.setOnClickListener {
				hideBottomDialogView()
				listener.topButtonClicked()
			}
		}

		// Bottom button parameters
		bottomButtonView.text = bottomDialogModel.bottomButtonText
		bottomButtonView.setTextSize(TypedValue.COMPLEX_UNIT_SP, bottomDialogModel.bottomButtonTextSize.toFloat())
		bottomButtonView.setTextColor(bottomDialogModel.bottomButtonTextColor)
		bottomButtonView.setTypeface(
			bottomButtonView.typeface,
			bottomDialogModel.bottomButtonTypeface
		)
		bottomButtonView.setOnClickListener {
			hideBottomDialogView()
			listener.bottomButtonClicked()
		}

		// Cancel button parameters
		cancelButtonView.text = bottomDialogModel.cancelButtonText
		cancelButtonView.setTextSize(TypedValue.COMPLEX_UNIT_SP, bottomDialogModel.cancelButtonTextSize.toFloat())
		cancelButtonView.setTextColor(bottomDialogModel.cancelButtonTextColor)
		cancelButtonView.setTypeface(
			cancelButtonView.typeface,
			bottomDialogModel.cancelButtonTypeface
		)
		cancelButtonView.setOnClickListener {
			hideBottomDialogView()
			listener.cancelButtonClicked()
		}

		return this
	}

	private fun hideBottomDialogView() {
		AnimationHelper().fadeOut(
			dialogView,
			bottomDialogModel.animationDuration
		)

		AnimationHelper().flyOutToBottom(
			dialogContainer,
			bottomDialogModel.animationDuration
		)

		Thread {
			Handler(Looper.getMainLooper()).postDelayed({
				view.removeView(dialogView)
			}, bottomDialogModel.animationDuration + 200)
		}.start()
	}

	private fun showBottomDialogView() {
		AnimationHelper().fadeIn(
			dialogView,
			bottomDialogModel.animationDuration
		)

		AnimationHelper().flyInFromBottom(
			dialogContainer,
			bottomDialogModel.animationDuration
		)
	}
}