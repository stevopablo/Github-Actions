package br.com.todolist.top1.exception;

public class TaskIdNotFoundException extends Throwable {
    public TaskIdNotFoundException(String msg) {
        super(msg);
    }
}
