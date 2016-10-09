package protocolsupport.protocol.core;

import com.google.common.base.Throwables;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import protocolsupport.ProtocolSupport;
import protocolsupport.protocol.core.wrapped.WrappedDecoder;
import protocolsupport.protocol.core.wrapped.WrappedEncoder;
import protocolsupport.protocol.core.wrapped.WrappedPrepender;
import protocolsupport.protocol.core.wrapped.WrappedSplitter;
import protocolsupport.utils.Utils;

public class ChannelHandlers {

	public static final String INITIAL_DECODER = "initial_decoder";
	public static final String LEGACY_KICK = "legacy_kick";
	public static final String TIMEOUT = "timeout";
	public static final String SPLITTER = "splitter";
	public static final String PREPENDER = "prepender";
	public static final String DECODER = "decoder";
	public static final String ENCODER = "encoder";
	public static final String NETWORK_MANAGER = "packet_handler";
	public static final String DECRYPT = "decrypt";

	public static WrappedDecoder getDecoder(ChannelPipeline pipeline) {
		ChannelHandler decoder = pipeline.get(DECODER);
		if (ProtocolSupport.lilypad && !(decoder instanceof WrappedDecoder)) {
			try {
				decoder = (ChannelHandler) Utils.setAccessible(decoder.getClass().getDeclaredField("oldDecoder")).get(decoder);
			} catch (NoSuchFieldException | IllegalAccessException exception) {
				throw Throwables.propagate(exception);
			}
		}

		return (WrappedDecoder) decoder;
	}

	public static WrappedEncoder getEncoder(ChannelPipeline pipeline) {
		return (WrappedEncoder) pipeline.get(ENCODER);
	}

	public static WrappedSplitter getSplitter(ChannelPipeline pipeline) {
		return (WrappedSplitter) pipeline.get(SPLITTER);
	}

	public static WrappedPrepender getPrepender(ChannelPipeline pipeline) {
		return (WrappedPrepender) pipeline.get(PREPENDER);
	}

}
