// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package compresspdftest.proxies.microflows;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public final class Microflows
{
	/**
	 * Private constructor to prevent instantiation of this class. 
	 */
	private Microflows() {}

	// These are the microflows for the CompressPdfTest module
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder compressPdfBuilder(
		compresspdftest.proxies.CompressionSettings _compressionSettings
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("CompressPdfTest.CompressPdf");
		builder = builder.withParam("CompressionSettings", _compressionSettings);
		return builder;
	}

	public static void compressPdf(
		IContext context,
		compresspdftest.proxies.CompressionSettings _compressionSettings
	)
	{
		compressPdfBuilder(
				_compressionSettings
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder createFileBuilder()
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("CompressPdfTest.CreateFile");
		return builder;
	}

	public static compresspdftest.proxies.File createFile(IContext context)
	{
		Object result = createFileBuilder().execute(context);
		return result == null ? null : compresspdftest.proxies.File.initialize(context, (IMendixObject) result);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder getCompressionLevelBuilder()
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("CompressPdfTest.GetCompressionLevel");
		return builder;
	}

	public static compresspdftest.proxies.CompressionSettings getCompressionLevel(IContext context)
	{
		Object result = getCompressionLevelBuilder().execute(context);
		return result == null ? null : compresspdftest.proxies.CompressionSettings.initialize(context, (IMendixObject) result);
	}
}
