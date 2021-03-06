/*
Copyright 2015 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.binnavi.debug.connection.packets.replyparsers;

import com.google.security.zynamics.binnavi.debug.connection.DebugCommandType;
import com.google.security.zynamics.binnavi.debug.connection.interfaces.ClientReader;
import com.google.security.zynamics.binnavi.debug.connection.packets.replies.WriteMemoryReply;

import java.io.IOException;

/**
 * Parser responsible for parsing replies to Write Memory requests.
 */
public final class WriteMemoryParser extends AbstractReplyParser<WriteMemoryReply> {
  /**
   * Creates a new Write Memory reply parser.
   *
   * @param clientReader Used to read messages sent by the debug client.
   */
  public WriteMemoryParser(final ClientReader clientReader) {
    super(clientReader, DebugCommandType.RESP_WRITE_MEMORY_SUCC);
  }

  @Override
  protected WriteMemoryReply parseError(final int packetId) throws IOException {
    return new WriteMemoryReply(packetId, parseInteger());
  }

  @Override
  public WriteMemoryReply parseSuccess(final int packetId, final int argumentCount) {
    return new WriteMemoryReply(packetId, 0);
  }
}
