package br.com.mariapuri.logserver.mydom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
  @Autowired
  private LogService logService;

  @PostMapping
  public ResponseEntity<LogEntry> createLog(@RequestParam String message, @RequestParam String level) {
    LogEntry logEntry = logService.saveLog(message, level);
    return new ResponseEntity<>(logEntry, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<LogEntry>> getLogs() {
    List<LogEntry> logs = logService.getAllLogs();
    return new ResponseEntity<>(logs, HttpStatus.OK);
  }
}

