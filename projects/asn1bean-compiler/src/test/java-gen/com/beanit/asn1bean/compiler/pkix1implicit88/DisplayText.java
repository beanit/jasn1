/**
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.pkix1implicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;

import com.beanit.asn1bean.compiler.pkix1explicit88.Attribute;
import com.beanit.asn1bean.compiler.pkix1explicit88.CertificateSerialNumber;
import com.beanit.asn1bean.compiler.pkix1explicit88.DirectoryString;
import com.beanit.asn1bean.compiler.pkix1explicit88.Name;
import com.beanit.asn1bean.compiler.pkix1explicit88.ORAddress;
import com.beanit.asn1bean.compiler.pkix1explicit88.RelativeDistinguishedName;

public class DisplayText implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] code = null;
	public BerIA5String ia5String = null;
	public BerVisibleString visibleString = null;
	public BerBMPString bmpString = null;
	public BerUTF8String utf8String = null;
	
	public DisplayText() {
	}

	public DisplayText(byte[] code) {
		this.code = code;
	}

	public DisplayText(BerIA5String ia5String, BerVisibleString visibleString, BerBMPString bmpString, BerUTF8String utf8String) {
		this.ia5String = ia5String;
		this.visibleString = visibleString;
		this.bmpString = bmpString;
		this.utf8String = utf8String;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			return code.length;
		}

		int codeLength = 0;
		if (utf8String != null) {
			codeLength += utf8String.encode(reverseOS, true);
			return codeLength;
		}
		
		if (bmpString != null) {
			codeLength += bmpString.encode(reverseOS, true);
			return codeLength;
		}
		
		if (visibleString != null) {
			codeLength += visibleString.encode(reverseOS, true);
			return codeLength;
		}
		
		if (ia5String != null) {
			codeLength += ia5String.encode(reverseOS, true);
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int tlvByteCount = 0;
		boolean tagWasPassed = (berTag != null);

		if (berTag == null) {
			berTag = new BerTag();
			tlvByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerIA5String.tag)) {
			ia5String = new BerIA5String();
			tlvByteCount += ia5String.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerVisibleString.tag)) {
			visibleString = new BerVisibleString();
			tlvByteCount += visibleString.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerBMPString.tag)) {
			bmpString = new BerBMPString();
			tlvByteCount += bmpString.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerUTF8String.tag)) {
			utf8String = new BerUTF8String();
			tlvByteCount += utf8String.decode(is, false);
			return tlvByteCount;
		}

		if (tagWasPassed) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (ia5String != null) {
			sb.append("ia5String: ").append(ia5String);
			return;
		}

		if (visibleString != null) {
			sb.append("visibleString: ").append(visibleString);
			return;
		}

		if (bmpString != null) {
			sb.append("bmpString: ").append(bmpString);
			return;
		}

		if (utf8String != null) {
			sb.append("utf8String: ").append(utf8String);
			return;
		}

		sb.append("<none>");
	}

}
