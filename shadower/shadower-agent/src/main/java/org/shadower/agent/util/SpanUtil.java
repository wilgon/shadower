package org.shadower.agent.util;

import java.util.concurrent.atomic.AtomicInteger;

import org.shadower.agent.entity.Attachment;
import org.shadower.api.Annotation;
import org.shadower.api.Span;

public final class SpanUtil {
	private static final AtomicInteger traceIdGenerator = new AtomicInteger(1);
	private static final AtomicInteger spanIdGenerator = new AtomicInteger(1);

	public static long generateTraceId() {
		return traceIdGenerator.getAndIncrement();
	}

	public static long generateSpanId(long parentId) {
		// 数据溢出
		return spanIdGenerator.getAndIncrement() + parentId;
	}

	public static Annotation generateAnnotation(int ipV4) {
		return new Annotation(System.currentTimeMillis(), ipV4);
	}

	public static Span generateSpan(Attachment attachment, String name) {
		Span span = new Span();
		span.setTraceId(attachment.getTraceId());
		span.setId(attachment.getId());
		span.setParentId(attachment.getParentId());
		span.setName(name);
		return span;
	}

}
