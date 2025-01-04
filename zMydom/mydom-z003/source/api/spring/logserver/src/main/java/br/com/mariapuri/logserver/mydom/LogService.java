package br.com.mariapuri.logserver.mydom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {
  @Autowired
  private LogRepository logRepository;

  public LogEntry saveLog(String message, String level) {
    LogEntry logEntry = new LogEntry();
    logEntry.setMessage(message);
    logEntry.setLevel(level);
    logEntry.setTimestamp(LocalDateTime.now());
    return logRepository.save(logEntry);
  }

  public List<LogEntry> getAllLogs() {
    return logRepository.findAll();
  }
}
