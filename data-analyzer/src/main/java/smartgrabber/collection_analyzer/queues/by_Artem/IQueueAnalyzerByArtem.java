package smartgrabber.collection_analyzer.queues.by_Artem;

import smartgrabber.collection_analyzer.IMemoryAnalyzer;

import java.util.Queue;

/**
 * Created by R-Tem on 13.11.2015.
 *
 * Интерфейс не должен переопрделять методы
 * которые описанны в родительском интерфейсе.
 *
 * Для того, что бы указать с чем должны работать методы
 * необходимо всего лишь использовать жденерики.
 */
public interface IQueueAnalyzerByArtem <T extends Queue> extends IMemoryAnalyzer <T> {
}
