/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.Iterator;
import java.util.Set;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.PropertyFormatUtil;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
import com.suggesthashtag.propertyloader.decorateProp.PropertyListHolder;
import com.suggesthashtag.propertyloader.decorateProp.PropertyLoaderObject;
import com.suggesthashtag.propertyloader.decorateProp.PropertyObjectHolder;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class PrepareOtherTypeHandlerPropDecorator extends
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
	public PrepareOtherTypeHandlerPropDecorator(
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
				PropertyLoaderObject propLoaderObject = decoratingObject
						.getProcessingPropertiesMap().get(
								propertyFile.toString());
				if (propLoaderObject != null
						&& propLoaderObject.getTempProperty() != null
						&& propLoaderObject.getTempProperty().size() > 0) {
					Property property = propLoaderObject.getTempProperty();
					Set<Object> keySet = property.keySet();
					Iterator<Object> keySetIterator = keySet.iterator();
					while (keySetIterator.hasNext()) {
						String key = (String) keySetIterator.next();
						String propValue = property.getProperty(key);
						if (propValue.toUpperCase().startsWith("LIST<")) {
							propLoaderObject
									.put(key,
											(PropertyListHolder) PropertyFormatUtil
													.getInstance()
													.formatPropertyValues(
															propValue,
															property,
															DataTypeEnum.LIST));
						} else if (propValue.toUpperCase()
								.startsWith("OBJECT<")) {
							propLoaderObject.put(
									key,
									(PropertyObjectHolder) PropertyFormatUtil
											.getInstance()
											.formatPropertyValues(propValue,
													property,
													DataTypeEnum.OBJECT));
						} else {
							decoratingObject.getFinalProperty().setProperty(
									key, propValue);
						}
					}
					decoratingObject.getProcessingPropertiesMap().put(
							propertyFile.toString(), propLoaderObject);
				}
			}

		}

		return decoratingObject;
	}
}
