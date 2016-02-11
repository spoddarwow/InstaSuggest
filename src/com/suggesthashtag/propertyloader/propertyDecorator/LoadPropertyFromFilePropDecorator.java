/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.decorateProp.PropertyLoaderObject;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class LoadPropertyFromFilePropDecorator extends
		PropertyDecoratorImplementation {

	private PropertyDecoratorInterface decoratorInterface;

	public PropertyDecoratorInterface getDecoratorInterface() {
		return this.decoratorInterface;
	}

	public void setDecoratorInterface(
			PropertyDecoratorInterface decoratorInterface) {
		this.decoratorInterface = decoratorInterface;
	}

	/**
	 * @param decoratorInterface
	 */
	public LoadPropertyFromFilePropDecorator(
			PropertyDecoratorInterface decoratorInterface) {
		super(decoratorInterface);
		this.decoratorInterface = decoratorInterface;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.propertyDecorator.
	 * PropertyDecoratorImplementation
	 * #processPropertyFiles(com.suggesthashtag.propertyloader
	 * .propertyDecorator.PropertyDecoratorObject)
	 */
	@Override
	public PropertyDecoratorObject processPropertyFiles(
			PropertyDecoratorObject decoratingObject) throws PropertyException {
		decoratingObject = super.processPropertyFiles(decoratingObject);
		if (decoratingObject != null
				&& !decoratingObject.getPropertyLoaderList().isEmpty()) {
			for (int index = 0; index < decoratingObject
					.getPropertyLoaderList().size(); index++) {
				PropertyLoaderDetails propertyFile = decoratingObject
						.getPropertyLoaderList().get(index);
				PropertyLoaderObject loaderObject = new PropertyLoaderObject();
				loaderObject.setIndex(index);
				Property tempProperty = new Property();
				try {
					InputStream inputStream = PropertyLoader.class
							.getClassLoader().getResourceAsStream(
									propertyFile.toString());
					if (inputStream != null) {
						tempProperty.load(inputStream);
						loaderObject.setTempProperty(tempProperty);
					} else {
						throw new FileNotFoundException("Property file "
								+ propertyFile.toString()
								+ " not found in the classpath");
					}
					decoratingObject.getProcessingPropertiesMap().put(
							propertyFile.toString(), loaderObject);
				} catch (FileNotFoundException exception) {
					exception.printStackTrace();
				} catch (IOException exception) {
					exception.printStackTrace();
				}

			}

		}

		return decoratingObject;
	}

}
