/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.modules.module1;

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

import com.beanit.asn1bean.compiler.modules.module2.EmployeeNumberZ;
import com.beanit.asn1bean.compiler.modules.module3.Datezz;
import com.beanit.asn1bean.compiler.modules.module3.EmployeeNumberzz;

public class MyDate2 extends Date {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 9);

	public MyDate2() {
	}

	public MyDate2(byte[] value) {
		super(value);
	}

	@Override public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		int codeLength;

		codeLength = super.encode(reverseOS, false);
		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;
	}

	@Override public int decode(InputStream is, boolean withTag) throws IOException {

		int codeLength = 0;

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += super.decode(is, false);

		return codeLength;
	}

}
