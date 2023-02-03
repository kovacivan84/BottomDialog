package com.kovacivan.bottomdialog

internal class BottomDialogModel: java.io.Serializable {
	var animationDuration: Long = Constants.DEFAULT_DURATION
	var titleText: String = Constants.TITLE_TEXT
	var titleTextSize: Int = Constants.TITLE_TEXT_SIZE
	var titleTextColor: Int = Constants.TITLE_TEXT_COLOR
	var titleTypeface: Int = Constants.TITLE_TYPEFACE
	var topButtonText: String = Constants.TOP_BUTTON_TEXT
	var topButtonTextColor: Int = Constants.TOP_BUTTON_TEXT_COLOR
	var topButtonTextSize: Int = Constants.TOP_BUTTON_TEXT_SIZE
	var hideTopButton: Boolean = Constants.HIDE_TOP_BUTTON
	var topButtonTypeface: Int = Constants.TOP_BUTTON_TYPEFACE
	var bottomButtonText: String = Constants.BOTTOM_BUTTON_TEXT
	var bottomButtonTextColor: Int = Constants.BOTTOM_BUTTON_TEXT_COLOR
	var bottomButtonTextSize: Int = Constants.BOTTOM_BUTTON_TEXT_SIZE
 	var bottomButtonTypeface: Int = Constants.BOTTOM_BUTTON_TYPEFACE
	var cancelButtonText: String = Constants.CANCEL_BUTTON_TEXT
	var cancelButtonTextColor: Int = Constants.CANCEL_BUTTON_TEXT_COLOR
	var cancelButtonTextSize: Int = Constants.CANCEL_BUTTON_TEXT_SIZE
	var cancelButtonTypeface: Int = Constants.CANCEL_BUTTON_TYPEFACE
	var backgroundOverlayState: Boolean = Constants.BACKGROUND_OVERLAY_STATE
	var backgroundOverlayTransparencyPercentage: Float = Constants.BACKGROUND_OVERLAY_TRANSPARENCY_PERCENTAGE
	var backgroundOverlayColor: Int = Constants.BACKGROUND_OVERLAY_COLOR
	var hideOnBackgroundClick: Boolean = Constants.HIDE_ON_BACKGROUND_CLICK
}