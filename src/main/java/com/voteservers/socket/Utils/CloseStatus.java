package com.voteservers.socket.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CloseStatus {

    private int code;
    private String reason;
    private boolean remote;

}
