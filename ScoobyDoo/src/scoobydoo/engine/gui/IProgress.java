package scoobydoo.engine.gui;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Implementations of this class are used to track progress for progress bars
 */
public interface IProgress {

	/**
	 * Returns the current progress
	 */
	int getProgress();

	/**
	 * An implementation of <code>IProgress</code> that uses the value of a
	 * field to get its progress
	 */
	public static class FieldValue implements IProgress {
		private Object instance;
		private Field field;

		public FieldValue(Class<?> owningClass, Object instance, String fieldName) {
			this.instance = instance;
			try {
				this.field = owningClass.getDeclaredField(fieldName);
				if (field.getType() != int.class) {
					throw new IllegalArgumentException("That field is not of type int");
				}
				field.setAccessible(true);
			} catch (Exception e) {
				throw new RuntimeException("Invalid field", e);
			}
		}

		public FieldValue(Object instance, String fieldName) {
			this(instance.getClass(), instance, fieldName);
		}

		@Override
		public int getProgress() {
			try {
				return field.getInt(instance);
			} catch (Exception e) {
				throw new RuntimeException("Exception getting field", e);
			}
		}
	}

	/**
	 * An implementation of <code>IProgress</code> that calls a method to get
	 * its progress
	 */
	public static class CallMethod implements IProgress {
		private Object instance;
		private Method method;

		public CallMethod(Class<?> owningClass, Object instance, String methodName) {
			this.instance = instance;
			try {
				this.method = owningClass.getDeclaredMethod(methodName);
				if (method.getReturnType() != int.class) {
					throw new IllegalArgumentException("That method does not return an int");
				}
				method.setAccessible(true);
			} catch (Exception e) {
				throw new RuntimeException("Invalid method", e);
			}
		}

		public CallMethod(Object instance, String methodName) {
			this(instance.getClass(), instance, methodName);
		}

		@Override
		public int getProgress() {
			try {
				return (Integer) method.invoke(instance);
			} catch (Exception e) {
				throw new RuntimeException("Exception calling method");
			}
		}
	}

}
