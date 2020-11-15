package chavevalor;

import org.apache.thrift.TException;
import java.util.HashMap;
import chavevalor.*;

public class ChaveValorHandler implements ChaveValor.Iface {
  private HashMap<Integer,String> kv = new HashMap<>();
  public String oldValue;
  @Override
  public String getKV(int key) throws TException {
    if(kv.containsKey(key) && oldValue != null)
      return oldValue;
    else
      throw new KeyNotFound();
  }
  @Override
  public boolean setKV(int key, String valor) throws TException {
    oldValue = kv.get(key);
    kv.put(key,valor);
    return true;
  }
  @Override
  public void delKV(int key) throws TException {
    kv.remove(key);
  }
}