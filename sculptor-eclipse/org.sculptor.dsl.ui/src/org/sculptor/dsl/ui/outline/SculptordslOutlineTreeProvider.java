/*
* generated by Xtext
*/
package org.sculptor.dsl.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.sculptor.dsl.sculptordsl.DslModel;
import org.sculptor.dsl.sculptordsl.DslParameter;
import org.sculptor.dsl.sculptordsl.DslRepositoryOperation;
import org.sculptor.dsl.sculptordsl.DslServiceOperation;

/**
 * Customization of the default outline structure.
 * <p>
 * The following model elements are skipped in the outline:
 * <ul>
 * <li>Root node of type {@link DslModel}
 * <li>Type of {@link DslParameter}
 * <li>Return type of {@link DslRepositoryOperation} and {@link DslServiceOperation}
 * </ul>
 */
public class SculptordslOutlineTreeProvider extends DefaultOutlineTreeProvider {

	protected void _createChildren(DocumentRootNode parentNode, EObject modelElement) {
		for (EObject childElement : modelElement.eContents())
			createNode(parentNode, childElement);
	}

	protected boolean _isLeaf(DslParameter parameter) {
		return true;
	}

	protected void _createChildren(IOutlineNode parentNode, DslParameter parameter) {
	}

	protected boolean _isLeaf(DslRepositoryOperation op) {
		return op.getParameters().isEmpty();
	}

	protected void _createChildren(IOutlineNode parentNode, DslRepositoryOperation op) {
		for (EObject childElement : op.getParameters()) {
			createNode(parentNode, childElement);
		}
	}

	protected boolean _isLeaf(DslServiceOperation op) {
		return op.getParameters().isEmpty();
	}

	protected void _createChildren(IOutlineNode parentNode, DslServiceOperation op) {
		for (EObject childElement : op.getParameters()) {
			createNode(parentNode, childElement);
		}
	}
	
}
