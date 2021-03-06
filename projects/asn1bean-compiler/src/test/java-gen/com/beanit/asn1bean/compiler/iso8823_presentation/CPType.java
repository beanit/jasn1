/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.iso8823_presentation;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;


public class CPType implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class NormalModeParameters implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

		private byte[] code = null;
		public ProtocolVersion protocolVersion = null;
		public CallingPresentationSelector callingPresentationSelector = null;
		public CalledPresentationSelector calledPresentationSelector = null;
		public PresentationContextDefinitionList presentationContextDefinitionList = null;
		public DefaultContextName defaultContextName = null;
		public PresentationRequirements presentationRequirements = null;
		public UserSessionRequirements userSessionRequirements = null;
		public UserData userData = null;
		
		public NormalModeParameters() {
		}

		public NormalModeParameters(byte[] code) {
			this.code = code;
		}

		public NormalModeParameters(ProtocolVersion protocolVersion, CallingPresentationSelector callingPresentationSelector, CalledPresentationSelector calledPresentationSelector, PresentationContextDefinitionList presentationContextDefinitionList, DefaultContextName defaultContextName, PresentationRequirements presentationRequirements, UserSessionRequirements userSessionRequirements, UserData userData) {
			this.protocolVersion = protocolVersion;
			this.callingPresentationSelector = callingPresentationSelector;
			this.calledPresentationSelector = calledPresentationSelector;
			this.presentationContextDefinitionList = presentationContextDefinitionList;
			this.defaultContextName = defaultContextName;
			this.presentationRequirements = presentationRequirements;
			this.userSessionRequirements = userSessionRequirements;
			this.userData = userData;
		}

		@Override public int encode(OutputStream reverseOS) throws IOException {
			return encode(reverseOS, true);
		}

		public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

			if (code != null) {
				reverseOS.write(code);
				if (withTag) {
					return tag.encode(reverseOS) + code.length;
				}
				return code.length;
			}

			int codeLength = 0;
			if (userData != null) {
				codeLength += userData.encode(reverseOS);
			}
			
			if (userSessionRequirements != null) {
				codeLength += userSessionRequirements.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 9
				reverseOS.write(0x89);
				codeLength += 1;
			}
			
			if (presentationRequirements != null) {
				codeLength += presentationRequirements.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 8
				reverseOS.write(0x88);
				codeLength += 1;
			}
			
			if (defaultContextName != null) {
				codeLength += defaultContextName.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
				reverseOS.write(0xA6);
				codeLength += 1;
			}
			
			if (presentationContextDefinitionList != null) {
				codeLength += presentationContextDefinitionList.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
				reverseOS.write(0xA4);
				codeLength += 1;
			}
			
			if (calledPresentationSelector != null) {
				codeLength += calledPresentationSelector.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				reverseOS.write(0x82);
				codeLength += 1;
			}
			
			if (callingPresentationSelector != null) {
				codeLength += callingPresentationSelector.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				reverseOS.write(0x81);
				codeLength += 1;
			}
			
			if (protocolVersion != null) {
				codeLength += protocolVersion.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				reverseOS.write(0x80);
				codeLength += 1;
			}
			
			codeLength += BerLength.encodeLength(reverseOS, codeLength);

			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}

			return codeLength;

		}

		@Override public int decode(InputStream is) throws IOException {
			return decode(is, true);
		}

		public int decode(InputStream is, boolean withTag) throws IOException {
			int tlByteCount = 0;
			int vByteCount = 0;
			int numDecodedBytes;
			BerTag berTag = new BerTag();

			if (withTag) {
				tlByteCount += tag.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			tlByteCount += length.decode(is);
			int lengthVal = length.val;
			if (lengthVal == 0) {
				return tlByteCount;
			}
			vByteCount += berTag.decode(is);

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
				protocolVersion = new ProtocolVersion();
				vByteCount += protocolVersion.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
				callingPresentationSelector = new CallingPresentationSelector();
				vByteCount += callingPresentationSelector.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
				calledPresentationSelector = new CalledPresentationSelector();
				vByteCount += calledPresentationSelector.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
				presentationContextDefinitionList = new PresentationContextDefinitionList();
				vByteCount += presentationContextDefinitionList.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
				defaultContextName = new DefaultContextName();
				vByteCount += defaultContextName.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
				presentationRequirements = new PresentationRequirements();
				vByteCount += presentationRequirements.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 9)) {
				userSessionRequirements = new UserSessionRequirements();
				vByteCount += userSessionRequirements.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			userData = new UserData();
			numDecodedBytes = userData.decode(is, berTag);
			if (numDecodedBytes != 0) {
				vByteCount += numDecodedBytes;
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			else {
				userData = null;
			}
			if (lengthVal < 0) {
				if (!berTag.equals(0, 0, 0)) {
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				vByteCount += BerLength.readEocByte(is);
				return tlByteCount + vByteCount;
			}

			throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);

		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS, false);
			code = reverseOS.getArray();
		}

		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			sb.append("{");
			boolean firstSelectedElement = true;
			if (protocolVersion != null) {
				sb.append("\n");
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("protocolVersion: ").append(protocolVersion);
				firstSelectedElement = false;
			}
			
			if (callingPresentationSelector != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("callingPresentationSelector: ").append(callingPresentationSelector);
				firstSelectedElement = false;
			}
			
			if (calledPresentationSelector != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("calledPresentationSelector: ").append(calledPresentationSelector);
				firstSelectedElement = false;
			}
			
			if (presentationContextDefinitionList != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("presentationContextDefinitionList: ");
				presentationContextDefinitionList.appendAsString(sb, indentLevel + 1);
				firstSelectedElement = false;
			}
			
			if (defaultContextName != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("defaultContextName: ");
				defaultContextName.appendAsString(sb, indentLevel + 1);
				firstSelectedElement = false;
			}
			
			if (presentationRequirements != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("presentationRequirements: ").append(presentationRequirements);
				firstSelectedElement = false;
			}
			
			if (userSessionRequirements != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("userSessionRequirements: ").append(userSessionRequirements);
				firstSelectedElement = false;
			}
			
			if (userData != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("userData: ");
				userData.appendAsString(sb, indentLevel + 1);
			}
			
			sb.append("\n");
			for (int i = 0; i < indentLevel; i++) {
				sb.append("\t");
			}
			sb.append("}");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 17);

	private byte[] code = null;
	public ModeSelector modeSelector = null;
	public NormalModeParameters normalModeParameters = null;
	
	public CPType() {
	}

	public CPType(byte[] code) {
		this.code = code;
	}

	public CPType(ModeSelector modeSelector, NormalModeParameters normalModeParameters) {
		this.modeSelector = modeSelector;
		this.normalModeParameters = normalModeParameters;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (normalModeParameters != null) {
			codeLength += normalModeParameters.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			reverseOS.write(0xA2);
			codeLength += 1;
		}
		
		codeLength += modeSelector.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
		reverseOS.write(0xA0);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;

		while (vByteCount < lengthVal || lengthVal < 0) {
			vByteCount += berTag.decode(is);
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
				modeSelector = new ModeSelector();
				vByteCount += modeSelector.decode(is, false);
			}
			else if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
				normalModeParameters = new NormalModeParameters();
				vByteCount += normalModeParameters.decode(is, false);
			}
			else if (lengthVal < 0 && berTag.equals(0, 0, 0)) {
				vByteCount += BerLength.readEocByte(is);
				return tlByteCount + vByteCount;
			}
			else {
				throw new IOException("Tag does not match any set component: " + berTag);
			}
		}
		if (vByteCount != lengthVal) {
			throw new IOException("Length of set does not match length tag, length tag: " + lengthVal + ", actual set length: " + vByteCount);
		}
		return tlByteCount + vByteCount;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (modeSelector != null) {
			sb.append("modeSelector: ");
			modeSelector.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("modeSelector: <empty-required-field>");
		}
		
		if (normalModeParameters != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("normalModeParameters: ");
			normalModeParameters.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

