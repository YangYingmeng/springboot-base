--call是调用redis get(Key) 与 入参第一个进行比较 如果不相等执行return 0; 如果相等则set(key, 第二个入参)
if redis.call('GET', KEYS[1]) ~= ARGV[1] then
    return 0;
end
redis.call('SET', KEYS[1], ARGV[2])
return 1
