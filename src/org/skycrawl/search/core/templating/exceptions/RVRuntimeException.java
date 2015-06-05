package org.skycrawl.search.core.templating.exceptions;

public class RVRuntimeException extends RuntimeException
{
	private static final long	serialVersionUID	= 8667620835522601357L;

	public RVRuntimeException()
	{
		super();
	}

	public RVRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RVRuntimeException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RVRuntimeException(String message)
	{
		super(message);
	}

	public RVRuntimeException(Throwable cause)
	{
		super(cause);
	}
}
