package com.kovacivan.bottomdialog

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator

internal class AnimationHelper {

	fun flyInFromBottom(view: View, animationDuration: Long) {
		view.translationY = 2000f
		val flyIn = ValueAnimator.ofFloat(2000f, 0f).apply {
			interpolator = DecelerateInterpolator()
			duration = animationDuration
		}

		flyIn.addUpdateListener {
			val value = it.animatedValue as Float

			view.translationY = value
		}

		AnimatorSet().apply {
			play(flyIn)
			start()
		}
	}

	fun flyOutToBottom(view: View, animationDuration: Long) {
		val flyOut = ValueAnimator.ofFloat(0f, 2000f).apply {
			interpolator = AccelerateInterpolator()
			duration = animationDuration
		}

		flyOut.addUpdateListener {
			val value = it.animatedValue as Float

			view.translationY = value
		}

		AnimatorSet().apply {
			play(flyOut)
			start()
		}
	}

	fun fadeIn(view: View, animationDuration: Long) {
		view.alpha = 0f
		val fadeIn = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).apply {
			duration = animationDuration
		}
		AnimatorSet().apply {
			play(fadeIn)
			start()
		}
	}

	fun fadeOut(view: View, animationDuration: Long) {
		view.alpha = 1f
		val fadeOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f).apply {
			duration = animationDuration
		}
		AnimatorSet().apply {
			play(fadeOut)
			start()
		}
	}
}