/*
 * generated by Xtext
 */
package org.opendaylight.nemo.tool.eclipse.plugin.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.Connection;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.ConnectionUpdate;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.EditorPackage;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.Flow;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.FlowUpdate;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.Model;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.Node;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.NodeModel;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.NodeOperating;
import org.opendaylight.nemo.tool.eclipse.plugin.editor.Operation;
import org.opendaylight.nemo.tool.eclipse.plugin.services.EditorGrammarAccess;

@SuppressWarnings("all")
public class EditorSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private EditorGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == EditorPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EditorPackage.CONNECTION:
				sequence_Connection(context, (Connection) semanticObject); 
				return; 
			case EditorPackage.CONNECTION_UPDATE:
				sequence_ConnectionUpdate(context, (ConnectionUpdate) semanticObject); 
				return; 
			case EditorPackage.FLOW:
				sequence_Flow(context, (Flow) semanticObject); 
				return; 
			case EditorPackage.FLOW_UPDATE:
				sequence_FlowUpdate(context, (FlowUpdate) semanticObject); 
				return; 
			case EditorPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case EditorPackage.NODE:
				sequence_Node(context, (Node) semanticObject); 
				return; 
			case EditorPackage.NODE_MODEL:
				sequence_NodeModel(context, (NodeModel) semanticObject); 
				return; 
			case EditorPackage.NODE_OPERATING:
				sequence_NodeOperating(context, (NodeOperating) semanticObject); 
				return; 
			case EditorPackage.OPERATION:
				sequence_Operation(context, (Operation) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (connectionname+=[Connection|NemoId] (endnode+=[Node|NemoId] endnode+=[Node|NemoId]*)?)
	 */
	protected void sequence_ConnectionUpdate(EObject context, ConnectionUpdate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=NemoId endnode+=[Node|NemoId] endnode+=[Node|NemoId]*)
	 */
	protected void sequence_Connection(EObject context, Connection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     flowId+=[Flow|NemoId]
	 */
	protected void sequence_FlowUpdate(EObject context, FlowUpdate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=NemoId
	 */
	protected void sequence_Flow(EObject context, Flow semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EditorPackage.Literals.FLOW__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EditorPackage.Literals.FLOW__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFlowAccess().getNameNemoIdTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     sentences+=Sentence*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=NemoId
	 */
	protected void sequence_NodeModel(EObject context, NodeModel semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EditorPackage.Literals.NODE_MODEL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EditorPackage.Literals.NODE_MODEL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNodeModelAccess().getNameNemoIdTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (nodename+=[Node|NemoId] (nodes+=[Node|NemoId] nodes+=[Node|NemoId]*)?)
	 */
	protected void sequence_NodeOperating(EObject context, NodeOperating semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=NemoId (nodes+=[Node|NemoId] nodes+=[Node|NemoId]*)?)
	 */
	protected void sequence_Node(EObject context, Node semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=NemoId value+=INT? targetId=[Flow|NemoId] targetNode=[Node|NemoId]?)
	 */
	protected void sequence_Operation(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
