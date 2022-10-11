#pragma once
#ifndef __DLL_HELPER_H__
#define __DLL_HELPER_H__

#include "include/jni.h"
#include <iostream>
#include <limits>

#ifdef max(a, b)

#undef max(a, b)

#endif

#define ios_cls std::cin.clear();std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

namespace ast {
	void print_prompt(JNIEnv* env, jobject obj, jstring prompt, jboolean newLine);
	void wait(char token, int amount);
}

#endif