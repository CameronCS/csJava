#include "pch.h"
#include "dllHelper.h"
#include <iostream>
#include <limits>
#include <thread>

#define java_false JNI_FALSE
#define java_true JNI_TRUE

void ast::print_prompt(JNIEnv* env, jobject obj, jstring prompt, jboolean newLine) {
	if (prompt != NULL) {
		const char* prompt_ = env->GetStringUTFChars(prompt, java_false);
		if (prompt_ != "") {
			std::cout << prompt_ << ": ";
		}
		env->ReleaseStringUTFChars(prompt, prompt_);
	}
	if (newLine == java_true) {
		std::cout << std::endl;
	}
}

void ast::wait(char token, int amount) {
	using namespace std::this_thread;
	using namespace std::chrono;
	if (token == 'n') {
		sleep_for(nanoseconds(amount));
		return;
	}
	if (token == 'z') {
		sleep_for(milliseconds(amount));
		return;
	}
	if (token == 's') {
		sleep_for(seconds(amount));
		return;
	}
	if (token == 'm') {
		sleep_for(minutes(amount));
		return;
	}
	if (token == 'h') {
		sleep_for(hours(amount));
		return;
	}
}